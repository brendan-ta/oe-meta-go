require go.inc

DEPENDS = "go-bootstrap-native"

SSTATE_SCAN_CMD = "true"

SRC_URI = "${SRC_URI_PREFIX}/go${PV}.src.tar.gz;subdir=go-${PV}"
SRC_URI[md5sum] = "dc57f93f323e9f8189e5ffc1f223e346"
SRC_URI[sha256sum] = "4dc1bbf3ff61f0c1ff2b19355e6d88151a70126268a47c761477686ef94748c8"

LIC_FILES_CHKSUM = "file://${WORKDIR}/go-${PV}/go/LICENSE;md5=5d4950ecb7b26d2c5e4e7b4e0dd74707"
