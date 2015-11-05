#!/bin/sh

_script_dir=`dirname $0`
cmd="java -jar ${_script_dir}/digitalocean-routine-0.1.0-SNAPSHOT-standalone.jar"
token="DIGITAL OCEAN ACCESS TOKEN"
image_id="IMAGE ID"
ssh_key="SSH KEY FINGER PRINT"

if [ $1 = "create" ]; then
   $cmd create $2 $token $image_id $ssh_key
fi

if [ $1 = "delete" ]; then
  $cmd delete $token
fi
