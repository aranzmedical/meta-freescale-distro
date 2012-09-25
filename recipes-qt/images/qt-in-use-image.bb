require qt-in-use-common.inc

QT_NAME = "qt4"

IMAGE_INSTALL = " \
    ${COMMON_INSTALL} \
    \
    ${XSERVER} \
    ${QT_DEMOS} \
    packagegroup-core-x11 \
    xorg-minimal-fonts \
    liberation-fonts \
    qt-in-industrial-embedded-smarthome \
"
ROOTFS_POSTPROCESS_COMMAND += "(cd ${IMAGE_ROOTFS}/usr/bin ; \
                                ln -s smarthome x-window-manager ) ; \
                                mkdir -p ${IMAGE_ROOTFS}/etc/profile.d ; \
                                echo 'export QT_GRAPHICSSYSTEM=raster' \
                                     > ${IMAGE_ROOTFS}/etc/profile.d/qt-config ;"
