#!/usr/bin/env bash
# Baut die Notiz-Demo-APK ohne Gradle – nur mit Android-SDK-Werkzeugen.
# Vorbild: das Build-Skript der S9-Bridge-App (schlank, nachvollziehbar, ohne Magie).
#
# Voraussetzungen:
#   - Android SDK mit build-tools (>= 30) und platforms/android-29
#   - JDK 11+ (javac, keytool), zip
#   - ANDROID_HOME gesetzt ODER Standardpfad ~/android-sdk
#
# Ergebnis: build/NotizDemo.apk (debug-signiert, direkt installierbar)
set -euo pipefail

ANDROID_HOME="${ANDROID_HOME:-$HOME/android-sdk}"
PROJECT="$(cd "$(dirname "$0")" && pwd)"
SRC="$PROJECT/app/src/main"
BUILD="$PROJECT/build"
PLATFORM="$ANDROID_HOME/platforms/android-29"
BT="$(ls -d "$ANDROID_HOME"/build-tools/* | sort -V | tail -1)"

for tool in "$BT/aapt2" "$BT/d8" "$BT/zipalign" "$BT/apksigner" "$PLATFORM/android.jar"; do
    [ -e "$tool" ] || { echo "FEHLT: $tool – bitte Android SDK prüfen (ANDROID_HOME=$ANDROID_HOME)"; exit 1; }
done

echo "=== Clean ==="
rm -rf "$BUILD"
mkdir -p "$BUILD/classes" "$BUILD/gen"

echo "=== aapt2: Ressourcen kompilieren + linken ==="
"$BT/aapt2" compile --dir "$SRC/res" -o "$BUILD/res.zip"
"$BT/aapt2" link \
    -o "$BUILD/base.apk" \
    -I "$PLATFORM/android.jar" \
    --manifest "$SRC/AndroidManifest.xml" \
    --java "$BUILD/gen" \
    "$BUILD/res.zip"

echo "=== javac ==="
javac --release 8 \
    -cp "$PLATFORM/android.jar:$BUILD/gen" \
    -d "$BUILD/classes" \
    $(find "$SRC/java" "$BUILD/gen" -name '*.java')

echo "=== d8 (dex) ==="
"$BT/d8" \
    --lib "$PLATFORM/android.jar" \
    --min-api 26 \
    --output "$BUILD" \
    $(find "$BUILD/classes" -name '*.class')

echo "=== classes.dex einpacken ==="
(cd "$BUILD" && zip -q base.apk classes.dex)

echo "=== zipalign ==="
"$BT/zipalign" -f 4 "$BUILD/base.apk" "$BUILD/aligned.apk"

echo "=== Signieren (Debug-Key) ==="
KS="$PROJECT/debug.keystore"
if [ ! -f "$KS" ]; then
    keytool -genkeypair -keystore "$KS" -storepass android -keypass android \
        -alias androiddebugkey -keyalg RSA -keysize 2048 -validity 10000 \
        -dname "CN=Android Debug,O=Android,C=US"
fi
"$BT/apksigner" sign \
    --ks "$KS" --ks-pass pass:android --key-pass pass:android \
    --ks-key-alias androiddebugkey \
    --out "$BUILD/NotizDemo.apk" "$BUILD/aligned.apk"

"$BT/apksigner" verify "$BUILD/NotizDemo.apk"
echo "=== FERTIG: $BUILD/NotizDemo.apk ==="
