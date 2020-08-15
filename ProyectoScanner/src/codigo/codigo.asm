;Código TASM

.MODEL small

.STACK 200h

.DATA
t5 DW 1 DUP(0)
t6 DW 1 DUP(0)
t7 DW 1 DUP(0)
t8 DW 1 DUP(0)
;dataFinal

.CODE
	.STARUP
mov ax,@data
mov ds,ax
mov es,ax
mov ax,2
cmp 3,ax
je label3
mov ax,z
add ax,2
mov t5,ax
mov ax,t5
add ax,4
mov t6,ax
jump label4
label3:
mov ax,c
add ax,2
mov t7,ax
mov ax,t7
add ax,3
mov t8,ax
label4:
;codeFinal

	.EXIT

END
