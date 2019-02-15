DESCRIPTION = "Wrapper to add version info to Golang applications"
LICENSE = "BSD-3-Clause"
DEPENDS = ""
PR = "r2"

LIC_FILES_CHKSUM = "file://LICENSE;md5=1dee6bcd7a3e8805555a1fcb0dfc29bb"

inherit go
inherit native

# Does not support go modules
export GO111MODULE="off"

SRC_URI = "git://github.com/ahmetb/govvv.git;protocol=http"

SRCREV = "b9ca931fac26e553941aa920b6f3d89d696b334f"

S = "${WORKDIR}/git"

do_compile() {
    go build -o govvv
}

do_install() {
    install -d "${D}/${bindir}"
    install -m 0755 "${S}/govvv" "${D}/${bindir}"
}

