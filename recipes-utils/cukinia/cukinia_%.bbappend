FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PV = "0.9.1"
SRCREV = "35d621f7abbf8453b37beeab6719705dcbfb4ed2"

SRC_URI += "file://cukinia.conf"

LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

do_install:append(){
    install -d ${D}${sysconfdir}/cukinia/
    install -m 0644 ${WORKDIR}/cukinia.conf ${D}${sysconfdir}/cukinia/
}
