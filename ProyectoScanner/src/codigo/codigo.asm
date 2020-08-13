;Código TASM

.MODEL

.STACK 200h

.DATA

.CODE
	.STARUP
mov ax,@data
mov ds,ax
mov es,ax

	.EXIT

END