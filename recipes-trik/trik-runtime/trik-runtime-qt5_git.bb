SRCREV="${AUTOREV}"
TRIK_RUNTIME_UPDATE = "${SRCREV}"
GIT_REVISION = "branch=master"
PV = "git${SRCREV}"
#PR="r${TRIK_RUNTIME_UPDATE}"
require trik-runtime-qt5.inc
DEPENDS += "python3 rsync-native"
DEPENDS += "gcc-sanitizers"
RDEPENDS:${PN} += "bash xz"

require trik-runtime-install-new.inc
DEPENDS += "rsync-native python3"

#OE_QMAKE_CXXFLAGS:append += " -fno-lto"

#We need to switch precompiled headers off until this issue is fixed in trik-runtime sources
#We need to disable sanitize_address until the issue with the high memory consumption of asan is fixed
EXTRA_QMAKEVARS_PRE += "-r CONFIG+=release CONFIG+=ltcg CONFIG+=use_gold_linker \
			CONFIG+=noPch CONFIG+=sanitize_undefined CONFIG+=sanitizer \
			CONFIG+=trik_new_age CONFIG+=trik_nopython"
# TRIK_PYTHON_VERSION = "3.12"
# EXTRA_QMAKEVARS_PRE += "PYTHON_VERSION=${TRIK_PYTHON_VERSION} PKGCONFIG+=python-${TRIK_PYTHON_VERSION}-embed"

OE_QMAKE_CFLAGS:append = " -U_TIME_BITS -U_FILE_OFFSET_BITS -D_FILE_OFFSET_BITS=32"
OE_QMAKE_CXXFLAGS:append = " -U_TIME_BITS -U_FILE_OFFSET_BITS -D_FILE_OFFSET_BITS=32"
OE_QMAKE_CPPFLAGS:append = " -U_TIME_BITS -U_FILE_OFFSET_BITS -D_FILE_OFFSET_BITS=32"

# For script gathering logs information
RDEPENDS:${PN} += "bash xz"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
#INHIBIT_PACKAGE_STRIP = "1"
#DEBUG_BUILD = "1"
