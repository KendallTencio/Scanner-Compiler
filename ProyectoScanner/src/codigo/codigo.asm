;Código TASM

.MODEL small

.STACK 200h

.DATA
t1 DW 1 DUP(0)
t2 DW 1 DUP(0)
t3 DW 1 DUP(0)
t4 DW 1 DUP(0)
t5 DW 1 DUP(0)
t6 DW 1 DUP(0)
;dataFinal

.CODE
	.STARUP
mov ax,@data
mov ds,ax
mov es,ax
mov ax,m
add ax,2
mov t1,ax
mov ax,t1
add ax,3
mov t2,ax
mov ax,t2
mov a,ax
mov ax,c
add ax,2
mov t3,ax
mov ax,t3
add ax,3
mov t4,ax
mov ax,t4
mov b,ax
mov ax,2
cmp 3,ax
je label1
mov ax,z
add ax,2
mov t5,ax
mov ax,t5
add ax,4
mov t6,ax
mov ax,t6
mov w,ax
label1:
;codeFinal

	.EXIT

END
