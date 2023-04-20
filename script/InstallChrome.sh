#!/bin/bash
set -ex
apt-get update
apt-get -y install curl
apt-get install wget
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
apt -y install ./google-chrome-stable_current_amd64.deb
apt-get -y install maven
apt-get -y install cucumber