#!/bin/bash

DOCKER_BUILDKIT=1 docker build -t <my-docker-registry>/<my-image-name>:<my-image-tag> .
