#!/bin/bash
sudo apt-get install default-jre -s > /dev/null 
sudo snap install ant --classic >/dev/null
sudo apt-get autoremove > /dev/null 
ant compile jar -quiet > /dev/null
java -jar dist/RealEstate.jar > /dev/null 
