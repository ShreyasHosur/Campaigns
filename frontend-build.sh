#!/usr/bin/env bash

current_working_directory=$(pwd)

echo "Current working directory is set to $current_working_directory"

client_build_directory=${current_working_directory}/client/src/dist

echo "Client build directory is set to $client_build_directory"


template_directory=${current_working_directory}/src/main/resources/templates

echo "Templates directory is set to $template_directory"

static_directory=${current_working_directory}/src/main/resources/static

asset_directory=${static_directory}/inventory

if [ -d "${static_directory}" ]; then
    echo "Found old asset directory. Removing old static assets."

    # remove old js files
    echo "Removing old assets..."
    rm -rvf ${asset_directory}

else
    echo "Static directory not found. Creating static directory..."
    mkdir ${static_directory}
fi

if [ -d "${template_directory}" ]; then
    echo "Found templates directory..."

    # remove old index.html
    echo "Removing old index.html"
    rm -v ${template_directory}/index.html


else
    echo "Template directory not found. Creating template directory..."
    mkdir -v ${template_directory}
fi

if [ -d "${client_build_directory}" ]; then
    echo "Static assets discovered... Copying assets..."

    cp ${client_build_directory}/index.html ${template_directory}
    echo "index.html copied to template directory -> ${template_directory}"


    echo "Copying assets..."
    echo "Build Directory -> ${client_build_directory}"
    echo "Target Copy Directory -> ${static_directory}"
    cp -vR ${client_build_directory}/inventory ${static_directory}
    echo "JS and CSS copied"

else
    echo "Static files were not found. Terminating build process... "
    exit 1
fi
