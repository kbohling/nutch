Quick run down on launching the OSGi environment:

The entire system is setup and configured to run from the top level directory.

Everything builds inside "build/osgi/".  That should be seen as the prototype
directory layout.


Run:
$ ./launch-osgi.sh

It is running a class named EmbeddedOSGi.  It will start an OSGi shell.  Use
"help" to identify more commands.

This merely launches an embedded shell, and starts the OSGi application up.  It
does not do anything else useful.  Use "shutdown" to exit the shell.

This is merely to get everything up and running in an OSGi environment.

