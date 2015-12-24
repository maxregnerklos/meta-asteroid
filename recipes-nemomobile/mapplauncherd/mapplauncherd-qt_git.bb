SUMMARY = "Qt plugin for mapplauncherd"
HOMEPAGE = "https://git.merproject.org/mer-core/mapplauncherd-qt"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://qtbooster/qtbooster.cpp;beginline=1;endline=18;md5=fb70bd5bb640878875111d8161fa303c"

SRC_URI = "git://git.merproject.org/mer-core/mapplauncherd-qt.git;protocol=https"
SRCREV = "8c2d34f64c7e21bcf394e937e71361da51e6077c"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qtdeclarative qtbase mapplauncherd"

do_configure_prepend() {
    sed -i "s@INCLUDEPATH += /usr/include/applauncherd@INCLUDEPATH += ${STAGING_INCDIR}/applauncherd@" ${S}/qtbooster/qtbooster.pro
}

FILES_${PN} += "/usr/share/mkspecs/features /usr/lib/systemd/user /usr/libexec/mapplauncherd"
FILES_${PN}-dbg += "/usr/libexec/mapplauncherd/.debug"