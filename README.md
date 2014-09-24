# About

An example project for websocket application using:

- [ring-jetty](https://github.com/federkasten/ring-jetty)
- [ring-jetty-server](https://github.com/federkasten/ring-jetty-server)
- [lein-ring-jetty](https://github.com/federkasten/lein-ring-jetty)

These projects are WIP, may contain some bugs.

And these ring/lein-ring forks heavily depend on Jetty9.
It is not compatible with other application containers and server frameworks

# Usage

## Running

To start a web server for the application, run:

    lein ring-jetty server

## Deploying

To create war archive, run:

    lein ring-jetty uberwar

## License

Copyright 2014 Takashi AOKI
