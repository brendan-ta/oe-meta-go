inherit cross

require go_${PV}.inc

DEPENDS = "virtual/${TARGET_PREFIX}gcc"

do_compile() {
  ## Setting `$GOBIN` doesn't do any good, looks like it ends up copying binaries there.
  export GOROOT_FINAL="${SYSROOT}${libdir}/go"

  setup_go_arch

  export CGO_ENABLED="1"
  ## TODO: consider setting GO_EXTLINK_ENABLED

  export CC="${BUILD_CC}"
  export CC_FOR_TARGET="${TARGET_PREFIX}gcc ${TARGET_CC_ARCH} --sysroot=${STAGING_DIR_TARGET}"
  export CXX_FOR_TARGET="${TARGET_PREFIX}g++ ${TARGET_CC_ARCH} --sysroot=${STAGING_DIR_TARGET}"
  export GO_CCFLAGS="${HOST_CFLAGS}"
  export GO_LDFLAGS="${HOST_LDFLAGS}"

  cd src && bash -x ./make.bash

  # log the resulting environment
  env "GOROOT=${WORKDIR}/go-${PV}/go" "${WORKDIR}/go-${PV}/go/bin/go" env
}
