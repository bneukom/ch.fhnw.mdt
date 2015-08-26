: _Hash
0
>r
rsp@
35
-
rsp! ( allocate 35 local variables )
1
l!
-rot
swap
rsp@
1
+
swap
_Init
-rot
rot
dup
0
-
0=
?GOTO lbl_125 ( jump if equal )
swap
2
Rot32
drop
swap
drop
GOTO lbl_124
Label lbl_125
drop
rsp@
1
+
swap
rot
_Update
dup
1
l@
-rot
0
-
0=
?GOTO lbl_127 ( jump if equal )
swap
2
Rot32
drop
GOTO lbl_124
Label lbl_127
drop
rsp@
1
+
swap
_Final
Label lbl_124
rsp@
35
+
rsp!
rdrop ( deallocate 35 local variables )
;