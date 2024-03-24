# Spring Boot CRaC + gRPC example

### Java version

```
openjdk 21.0.2 2024-01-16 LTS
OpenJDK Runtime Environment Zulu21.32+17-CRaC-CA (build 21.0.2+13-LTS)
OpenJDK 64-Bit Server VM Zulu21.32+17-CRaC-CA (build 21.0.2+13-LTS, mixed mode, sharing)
```

### OS

```
No LSB modules are available.
Distributor ID:	Ubuntu
Description:	Ubuntu 22.04.2 LTS
Release:	22.04
Codename:	jammy
```

In order to checkpoint execute the following command

```bash
jcmd com.itashiev.crac.CracApplication JDK.checkpoint
```

It fails with the following

```
59571:
An exception during a checkpoint operation:
jdk.internal.crac.mirror.CheckpointException
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=61 type=unknown path=anon_inode:[eventpoll]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=62 type=unknown path=anon_inode:[eventfd]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=63 type=unknown path=anon_inode:[timerfd]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=64 type=unknown path=anon_inode:[eventpoll]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=65 type=unknown path=anon_inode:[eventfd]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=66 type=unknown path=anon_inode:[timerfd]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=67 type=unknown path=anon_inode:[eventpoll]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=68 type=unknown path=anon_inode:[eventfd]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=69 type=unknown path=anon_inode:[timerfd]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=70 type=unknown path=anon_inode:[eventpoll]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=71 type=unknown path=anon_inode:[eventfd]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=72 type=unknown path=anon_inode:[timerfd]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=73 type=unknown path=anon_inode:[eventpoll]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=74 type=unknown path=anon_inode:[eventfd]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
        Suppressed: jdk.internal.crac.mirror.impl.CheckpointOpenResourceException: FD fd=75 type=unknown path=anon_inode:[timerfd]
                at java.base/jdk.internal.crac.mirror.Core.translateJVMExceptions(Core.java:117)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore1(Core.java:188)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestore(Core.java:286)
                at java.base/jdk.internal.crac.mirror.Core.checkpointRestoreInternal(Core.java:299)
```