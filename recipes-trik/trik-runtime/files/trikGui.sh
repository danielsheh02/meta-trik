#!/bin/sh
. /etc/profile.d/locale.sh
. /etc/profile.d/qws_display.sh
cd /home/root/trik && exec ./trikGui -qws 2>&1 1> /dev/null
