;Código TASM

.MODEL small

.STACK 200h

.DATA
;dataFinal

.CODE
	.STARTUP
mov ax,@data
mov ds,ax
mov es,ax
label1:
mov ax,2
cmp 3,ax
je label2
jmp label2:
jmp label1
label2:
;codeFinal

	.EXIT

END
