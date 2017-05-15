SUMMARY = "TRIK MSP430 firmware"
PR 	= "r7"
LICENSE = "CLOSED"

COMPATIBLE_MACHINE = "trikboard"

SRC_URI = "file://msp_reset.sh \
           file://msp-v6-latest.txt"
SRC_URI[md5sum] = "509100434b0d6831bbf434173e136618"
SRC_URI[sha256sum] = "bc97217374d57dca62e47e05f35d234309b1da7f15d910ba52134103405536b1"

S = "${WORKDIR}"

do_compile[noexec] = "1"

do_install(){
	install -d ${D}/etc/trik/msp430/

	install -m 0755 ${S}/msp_reset.sh ${D}/etc/trik/msp430/msp_reset.sh
	install -m 0644 ${S}/msp-v6-latest.txt ${D}/etc/trik/msp430/msp-firmware.txt
}

