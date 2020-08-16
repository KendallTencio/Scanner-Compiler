;Código TASM

.MODEL small

.STACK 200h

.DATA
t1 DW 1 DUP(0)
t2 DW 1 DUP(0)
t3 DW 1 DUP(0)
t4 DW 1 DUP(0)
;dataFinal

.CODE
	.STARTUP
mov ax,@data
mov ds,ax
mov es,ax
mov ax,2
cmp 3,ax
je label1
mov ax,z
add ax,2
mov t1,ax
mov ax,t1
add ax,4
mov t2,ax
mov ax,t2
mov w,ax
label1:
label2:
mov ax,5
cmp 4,ax
je label3
mov ax,z
add ax,2
mov t3,ax
mov ax,t3
add ax,4
mov t4,ax
mov ax,t4
mov w,ax
jmp label2
label3:
;codeFinal

	.EXIT

END
