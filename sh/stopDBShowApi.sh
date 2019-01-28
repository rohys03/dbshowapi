#!/bin/sh
export DBSHOWAPI_HOME=/app/puser/dbshowapi
pgrep -f $DBSHOWAPI_HOME |xargs kill
