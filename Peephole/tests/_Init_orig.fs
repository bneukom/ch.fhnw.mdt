: _Init
swap
over
256
-
?GOTO lbl_72 ( jump if not equal )
0
GOTO lbl_77
Label lbl_74
swap
over
2
Rot32
dup
_IV256
2
Rot32
+
-2
Rot32
@
swap
2over
nip
4
+
2
Rot32
+
-2
Rot32
!
Label lbl_75
swap
1+
swap
swap
Label lbl_77
dup
8
u<
?GOTO lbl_74 ( jump if less )
drop
0
over
12
+
!
0
over
13
+
!
0
GOTO lbl_81
Label lbl_78
swap
0
2over
nip
2over
nip
14
+
+
!
Label lbl_79
swap
1+
swap
swap
Label lbl_81
dup
16
u<
?GOTO lbl_78 ( jump if less )
drop
0
over
30
+
!
0
over
31
+
!
0
over
32
+
!
0
over
33
+
!
GOTO lbl_73
Label lbl_72
2
Rot32
drop
drop
2
( return int )
GOTO lbl_71
Label lbl_73
swap
over
!
0
over
1+
!
1
over
2
+
!
0
swap
3
+
!
0
;