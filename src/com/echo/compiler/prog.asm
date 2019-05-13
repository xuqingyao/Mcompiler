		global	main

		extern	malloc

		section	.bss
Static_Data_n_1:	resq	1

		section	.data
Static_Data_static_str_1:
		dq		1
		db		51, 0
Static_Data_static_str_2:
		dq		1
		db		50, 0
Static_Data_static_str_3:
		dq		1
		db		49, 0
Static_Data_static_str_4:
		dq		1
		db		32, 0

		section	.text

# function find

Block_find_start_1:
		push	r12
		push	r13
		push	rbx
		push	rbp
		sub		rsp, 8
		mov		rbp, rsp
		and		rdi, -1
		xor		rax, rax
		cmp		rdi, 1
		sete	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_if_then_1

Block_if_after_1:
		mov		r11, 2

Block_for_cond_1:
		mov		r10, r11
		imul		r10, r11
		and		r10, -1
		and		rdi, -1
		xor		rax, rax
		cmp		r10, rdi
		setle	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_for_body_1

Block_for_after_1:
		mov		r10, 1
		jmp		Block_is_prime_end_1

Block_for_body_1:
		mov		rbx, r11
		mov		rax, rdi
		mov		r8, rdx
		cdq
		idiv	rbx
		mov		r10, rdx
		mov		rdx, r8
		and		r10, -1
		xor		rax, rax
		cmp		r10, 0
		sete	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_if_then_2
		jmp		Block_for_step_1

Block_if_after_2:

Block_for_step_1:
		inc		r11
		jmp		Block_for_cond_1

Block_if_then_2:
		mov		r10, 0
		jmp		Block_is_prime_end_1

Block_if_then_1:
		mov		r10, 0

Block_is_prime_end_1:
		cmp		r10, 1
		je		Block_if_then_3

Block_if_after_3:
		mov		r10, 1
		neg		r10
		and		rsi, -1
		and		r10, -1
		xor		rax, rax
		cmp		rsi, r10
		sete	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_if_then_4
		jmp		Block_if_else_1

Block_if_then_4:
		mov		r10, rdi
		sub		r10, 2
		mov		r11, r10

Block_for_body_2:
		and		r11, -1
		xor		rax, rax
		cmp		r11, 1
		sete	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_if_then_5

Block_if_after_4:
		mov		r12, 2

Block_for_cond_2:
		mov		r10, r12
		imul		r10, r12
		and		r10, -1
		and		r11, -1
		xor		rax, rax
		cmp		r10, r11
		setle	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_for_body_3

Block_for_after_2:
		mov		r10, 1
		jmp		Block_is_prime_end_2

Block_for_body_3:
		mov		rbx, r12
		mov		rax, r11
		mov		r8, rdx
		cdq
		idiv	rbx
		mov		r10, rdx
		mov		rdx, r8
		and		r10, -1
		xor		rax, rax
		cmp		r10, 0
		sete	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_if_then_6
		jmp		Block_for_step_2

Block_if_then_6:
		mov		r10, 0
		jmp		Block_is_prime_end_2

Block_if_after_5:

Block_for_step_2:
		inc		r12
		jmp		Block_for_cond_2

Block_if_then_5:
		mov		r10, 0

Block_is_prime_end_2:
		cmp		r10, 1
		je		Block_if_then_7
		jmp		Block_for_step_3

Block_if_after_6:

Block_for_step_3:
		dec		r11
		jmp		Block_for_body_2

Block_if_then_7:
		sub		rdi, r11
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdi
		mov		rdi, qword [rsp]
		mov		rsi, r11
		add		rsp, 8
		call	Block_find_start_1
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		mov		r10, rax
		jmp		Block_find_end_1

Block_if_else_1:
		mov		r11, rdi
		dec		r11

Block_for_body_4:
		and		r11, -1
		xor		rax, rax
		cmp		r11, 1
		sete	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_if_then_8
		jmp		Block_if_after_7

Block_if_then_8:
		mov		r10, 0
		jmp		Block_is_prime_end_3

Block_if_after_7:
		mov		r10, 2

Block_for_cond_3:
		mov		r12, r10
		imul		r12, r10
		and		r12, -1
		and		r11, -1
		xor		rax, rax
		cmp		r12, r11
		setle	al
		mov		r12, rax
		cmp		r12, 1
		je		Block_for_body_5

Block_for_after_3:
		mov		r10, 1
		jmp		Block_is_prime_end_3

Block_for_body_5:
		mov		rbx, r10
		mov		rax, r11
		mov		r8, rdx
		cdq
		idiv	rbx
		mov		r12, rdx
		mov		rdx, r8
		and		r12, -1
		xor		rax, rax
		cmp		r12, 0
		sete	al
		mov		r12, rax
		cmp		r12, 1
		je		Block_if_then_9
		jmp		Block_for_step_4

Block_if_after_8:

Block_for_step_4:
		inc		r10
		jmp		Block_for_cond_3

Block_if_then_9:
		mov		r10, 0

Block_is_prime_end_3:
		cmp		r10, 1
		je		Block_and_lhs_true_1
		jmp		Block_for_step_5

Block_and_lhs_true_1:
		mov		r12, rdi
		sub		r12, r11
		and		r12, -1
		xor		rax, rax
		cmp		r12, 1
		sete	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_if_then_10
		jmp		Block_if_after_9

Block_if_then_10:
		mov		r10, 0
		jmp		Block_is_prime_end_4

Block_if_after_9:
		mov		r13, 2

Block_for_cond_4:
		mov		r10, r13
		imul		r10, r13
		and		r10, -1
		and		r12, -1
		xor		rax, rax
		cmp		r10, r12
		setle	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_for_body_6

Block_for_after_4:
		mov		r10, 1
		jmp		Block_is_prime_end_4

Block_for_body_6:
		mov		rbx, r13
		mov		rax, r12
		mov		r8, rdx
		cdq
		idiv	rbx
		mov		r10, rdx
		mov		rdx, r8
		and		r10, -1
		xor		rax, rax
		cmp		r10, 0
		sete	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_if_then_11
		jmp		Block_for_step_6

Block_if_then_11:
		mov		r10, 0

Block_is_prime_end_4:
		cmp		r10, 1
		je		Block_if_then_12
		jmp		Block_for_step_5

Block_if_after_10:

Block_for_step_5:
		dec		r11
		jmp		Block_for_body_4

Block_if_then_12:
		push	r11
		push	r10
		push	rdi
		push	rsi
		mov		rdi, Static_Data_static_str_1
		call	_println
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		push	r11
		push	r10
		push	rdi
		push	rsi
		mov		rdi, rsi
		call	_printInt
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		push	r11
		push	r10
		push	rdi
		push	rsi
		mov		rdi, Static_Data_static_str_4
		call	_print
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		push	r11
		push	r10
		push	rdi
		push	rsi
		mov		rdi, r11
		call	_printInt
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		push	r11
		push	r10
		push	rdi
		push	rsi
		mov		rdi, Static_Data_static_str_4
		call	_print
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		sub		rdi, r11
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdi
		mov		rdi, qword [rsp]
		add		rsp, 8
		call	_printlnInt
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		jmp		Block_find_end_1

Block_if_after_11:

Block_for_step_6:
		inc		r13
		jmp		Block_for_cond_4

Block_if_then_3:
		and		rsi, -1
		xor		rax, rax
		cmp		rsi, 0
		setg	al
		mov		r10, rax
		cmp		r10, 1
		je		Block_if_then_13

Block_if_else_2:
		push	r11
		push	r10
		push	rdi
		push	rsi
		mov		rdi, Static_Data_static_str_3
		call	_println
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdi
		mov		rdi, qword [rsp]
		add		rsp, 8
		call	_printlnInt
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		jmp		Block_find_end_1

Block_if_then_13:
		push	r11
		push	r10
		push	rdi
		push	rsi
		mov		rdi, Static_Data_static_str_2
		call	_println
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		push	r11
		push	r10
		push	rdi
		push	rsi
		mov		rdi, rsi
		call	_printInt
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		push	r11
		push	r10
		push	rdi
		push	rsi
		mov		rdi, Static_Data_static_str_4
		call	_print
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		push	r11
		push	r10
		push	rdi
		push	rsi
		push	rdi
		mov		rdi, qword [rsp]
		add		rsp, 8
		call	_printlnInt
		pop		rsi
		pop		rdi
		pop		r10
		pop		r11
		jmp		Block_find_end_1

Block_if_after_12:

Block_find_end_1:
		add		rsp, 8
		pop		rbp
		pop		rbx
		pop		r13
		pop		r12
		ret

# function main

main:
		push	rbx
		push	rbp
		sub		rsp, 8
		mov		rbp, rsp

Block_init_func_start_1:
		push	r11
		push	r10
		call	_getInt
		pop		r10
		pop		r11
		mov		r10, rax
		mov		r11, r10

Block_init_start_1:
		mov		r10, 1
		neg		r10
		push	r11
		push	r10
		mov		rdi, r11
		mov		rsi, r10
		call	Block_find_start_1
		pop		r10
		pop		r11
		mov		r10, rax

Block_work_start_1:
		mov		qword [Static_Data_n_1], r11
		mov		rax, 0
		add		rsp, 8
		pop		rbp
		pop		rbx
		ret


# built-in functions

default rel

global _builtin_string_concat
global _builtin_string_equal
global _builtin_string_not_equal
global _builtin_string_less
global _builtin_string_less_equal
global _print
global _println
global _printInt
global _printlnInt
global _getString
global _getInt
global _toString
global _member_string_substring
global _member_string_parseInt
global _member_string_ord

extern getchar
extern strlen
extern scanf
extern __stack_chk_fail
extern putchar
extern puts
extern printf
extern strcmp
extern malloc


SECTION .text   

_builtin_string_concat:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 48
        mov     qword [rbp-28H], rdi
        mov     qword [rbp-30H], rsi
        mov     rax, qword [rbp-28H]
        mov     rax, qword [rax]
        mov     dword [rbp-10H], eax
        mov     rax, qword [rbp-30H]
        mov     rax, qword [rax]
        mov     dword [rbp-0CH], eax
        mov     eax, dword [rbp-10H]
        lea     edx, [rax+9H]
        mov     eax, dword [rbp-0CH]
        add     eax, edx
        cdqe
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-8H], rax
        mov     edx, dword [rbp-10H]
        mov     eax, dword [rbp-0CH]
        add     eax, edx
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        mov     qword [rax], rdx
        add     qword [rbp-28H], 8
        add     qword [rbp-30H], 8
        add     qword [rbp-8H], 8
        mov     dword [rbp-1CH], -1
        mov     dword [rbp-18H], 0
L_001:  mov     eax, dword [rbp-18H]
        cmp     eax, dword [rbp-10H]
        jge     L_002
        add     dword [rbp-1CH], 1
        mov     eax, dword [rbp-1CH]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rdx, rax
        mov     eax, dword [rbp-18H]
        movsxd  rcx, eax
        mov     rax, qword [rbp-28H]
        add     rax, rcx
        movzx   eax, byte [rax]
        mov     byte [rdx], al
        add     dword [rbp-18H], 1
        jmp     L_001

L_002:  mov     dword [rbp-14H], 0
L_003:  mov     eax, dword [rbp-14H]
        cmp     eax, dword [rbp-0CH]
        jge     L_004
        add     dword [rbp-1CH], 1
        mov     eax, dword [rbp-1CH]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rdx, rax
        mov     eax, dword [rbp-14H]
        movsxd  rcx, eax
        mov     rax, qword [rbp-30H]
        add     rax, rcx
        movzx   eax, byte [rax]
        mov     byte [rdx], al
        add     dword [rbp-14H], 1
        jmp     L_003

L_004:  mov     eax, dword [rbp-1CH]
        cdqe
        lea     rdx, [rax+1H]
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        mov     rax, qword [rbp-8H]
        sub     rax, 8
        leave
        ret


_builtin_string_equal:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rax, qword [rbp-10H]
        lea     rdx, [rax+8H]
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        sete    al
        movzx   eax, al
        leave
        ret


_builtin_string_not_equal:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rax, qword [rbp-10H]
        lea     rdx, [rax+8H]
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        setne   al
        movzx   eax, al
        leave
        ret


_builtin_string_less:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rax, qword [rbp-10H]
        lea     rdx, [rax+8H]
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        shr     eax, 31
        movzx   eax, al
        leave
        ret


_builtin_string_less_equal:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rax, qword [rbp-10H]
        lea     rdx, [rax+8H]
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        setle   al
        movzx   eax, al
        leave
        ret


_print:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rsi, rax
        mov     edi, L_043
        mov     eax, 0
        call    printf
        nop
        leave
        ret


_println:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rdi, rax
        call    puts
        nop
        leave
        ret


_printInt:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 80
        mov     dword [rbp-44H], edi


        mov     rax, qword [fs:abs 28H]
        mov     qword [rbp-8H], rax
        xor     eax, eax
        cmp     dword [rbp-44H], 0
        jnz     L_005
        mov     edi, 48
        call    putchar
L_005:  cmp     dword [rbp-44H], 0
        jns     L_006
        neg     dword [rbp-44H]
        mov     edi, 45
        call    putchar
L_006:  mov     dword [rbp-38H], 0
L_007:  cmp     dword [rbp-44H], 0
        jle     L_008
        mov     esi, dword [rbp-38H]
        lea     eax, [rsi+1H]
        mov     dword [rbp-38H], eax
        mov     ecx, dword [rbp-44H]
        mov     edx, 1717986919
        mov     eax, ecx
        imul    edx
        sar     edx, 2
        mov     eax, ecx
        sar     eax, 31
        sub     edx, eax
        mov     eax, edx
        shl     eax, 2
        add     eax, edx
        add     eax, eax
        sub     ecx, eax
        mov     edx, ecx
        movsxd  rax, esi
        mov     dword [rbp+rax*4-30H], edx
        mov     ecx, dword [rbp-44H]
        mov     edx, 1717986919
        mov     eax, ecx
        imul    edx
        sar     edx, 2
        mov     eax, ecx
        sar     eax, 31
        sub     edx, eax
        mov     eax, edx
        mov     dword [rbp-44H], eax
        jmp     L_007

L_008:  mov     eax, dword [rbp-38H]
        sub     eax, 1
        mov     dword [rbp-34H], eax
L_009:  cmp     dword [rbp-34H], 0
        js      L_010
        mov     eax, dword [rbp-34H]
        cdqe
        mov     eax, dword [rbp+rax*4-30H]
        add     eax, 48
        mov     edi, eax
        call    putchar
        sub     dword [rbp-34H], 1
        jmp     L_009

L_010:  nop
        mov     rax, qword [rbp-8H]


        xor     rax, qword [fs:abs 28H]
        jz      L_011
        call    __stack_chk_fail
L_011:  leave
        ret


_printlnInt:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 80
        mov     dword [rbp-44H], edi


        mov     rax, qword [fs:abs 28H]
        mov     qword [rbp-8H], rax
        xor     eax, eax
        cmp     dword [rbp-44H], 0
        jnz     L_012
        mov     edi, 48
        call    putchar
L_012:  cmp     dword [rbp-44H], 0
        jns     L_013
        neg     dword [rbp-44H]
        mov     edi, 45
        call    putchar
L_013:  mov     dword [rbp-38H], 0
L_014:  cmp     dword [rbp-44H], 0
        jle     L_015
        mov     esi, dword [rbp-38H]
        lea     eax, [rsi+1H]
        mov     dword [rbp-38H], eax
        mov     ecx, dword [rbp-44H]
        mov     edx, 1717986919
        mov     eax, ecx
        imul    edx
        sar     edx, 2
        mov     eax, ecx
        sar     eax, 31
        sub     edx, eax
        mov     eax, edx
        shl     eax, 2
        add     eax, edx
        add     eax, eax
        sub     ecx, eax
        mov     edx, ecx
        movsxd  rax, esi
        mov     dword [rbp+rax*4-30H], edx
        mov     ecx, dword [rbp-44H]
        mov     edx, 1717986919
        mov     eax, ecx
        imul    edx
        sar     edx, 2
        mov     eax, ecx
        sar     eax, 31
        sub     edx, eax
        mov     eax, edx
        mov     dword [rbp-44H], eax
        jmp     L_014

L_015:  mov     eax, dword [rbp-38H]
        sub     eax, 1
        mov     dword [rbp-34H], eax
L_016:  cmp     dword [rbp-34H], 0
        js      L_017
        mov     eax, dword [rbp-34H]
        cdqe
        mov     eax, dword [rbp+rax*4-30H]
        add     eax, 48
        mov     edi, eax
        call    putchar
        sub     dword [rbp-34H], 1
        jmp     L_016

L_017:  mov     edi, 10
        call    putchar
        nop
        mov     rax, qword [rbp-8H]


        xor     rax, qword [fs:abs 28H]
        jz      L_018
        call    __stack_chk_fail
L_018:  leave
        ret


_getString:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     edi, 266
        call    malloc
        mov     qword [rbp-8H], rax
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rsi, rax
        mov     edi, L_043
        mov     eax, 0
        call    scanf
        mov     rax, qword [rbp-8H]
        add     rax, 8
        mov     rdi, rax
        call    strlen
        mov     rdx, rax
        mov     rax, qword [rbp-8H]
        mov     qword [rax], rdx
        mov     rax, qword [rbp-8H]
        leave
        ret


_getInt:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        call    getchar
        mov     byte [rbp-6H], al
        mov     byte [rbp-5H], 0
L_019:  cmp     byte [rbp-6H], 47
        jle     L_020
        cmp     byte [rbp-6H], 57
        jle     L_022
L_020:  cmp     byte [rbp-6H], 45
        jnz     L_021
        mov     byte [rbp-5H], 1
L_021:  call    getchar
        mov     byte [rbp-6H], al
        jmp     L_019

L_022:  movsx   eax, byte [rbp-6H]
        sub     eax, 48
        mov     dword [rbp-4H], eax
        call    getchar
        mov     byte [rbp-6H], al
L_023:  cmp     byte [rbp-6H], 47
        jle     L_024
        cmp     byte [rbp-6H], 57
        jg      L_024
        mov     edx, dword [rbp-4H]
        mov     eax, edx
        shl     eax, 2
        add     eax, edx
        add     eax, eax
        mov     edx, eax
        movsx   eax, byte [rbp-6H]
        add     eax, edx
        sub     eax, 48
        mov     dword [rbp-4H], eax
        call    getchar
        mov     byte [rbp-6H], al
        jmp     L_023

L_024:  cmp     byte [rbp-5H], 0
        jz      L_025
        mov     eax, dword [rbp-4H]
        neg     eax
        jmp     L_026

L_025:  mov     eax, dword [rbp-4H]
L_026:  leave
        ret


_toString:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 96
        mov     dword [rbp-54H], edi


        mov     rax, qword [fs:abs 28H]
        mov     qword [rbp-8H], rax
        xor     eax, eax
        mov     dword [rbp-44H], 0
        mov     dword [rbp-40H], 0
        cmp     dword [rbp-54H], 0
        jns     L_027
        mov     dword [rbp-44H], 1
        neg     dword [rbp-54H]
L_027:  cmp     dword [rbp-54H], 0
        jnz     L_028
        add     dword [rbp-40H], 1
        mov     eax, dword [rbp-40H]
        cdqe
        mov     dword [rbp+rax*4-30H], 0
        jmp     L_029

L_028:  cmp     dword [rbp-54H], 0
        jz      L_029
        add     dword [rbp-40H], 1
        mov     ecx, dword [rbp-54H]
        mov     edx, 1717986919
        mov     eax, ecx
        imul    edx
        sar     edx, 2
        mov     eax, ecx
        sar     eax, 31
        sub     edx, eax
        mov     eax, edx
        shl     eax, 2
        add     eax, edx
        add     eax, eax
        sub     ecx, eax
        mov     edx, ecx
        mov     eax, dword [rbp-40H]
        cdqe
        mov     dword [rbp+rax*4-30H], edx
        mov     ecx, dword [rbp-54H]
        mov     edx, 1717986919
        mov     eax, ecx
        imul    edx
        sar     edx, 2
        mov     eax, ecx
        sar     eax, 31
        sub     edx, eax
        mov     eax, edx
        mov     dword [rbp-54H], eax
        jmp     L_028

L_029:  mov     edx, dword [rbp-40H]
        mov     eax, dword [rbp-44H]
        add     eax, edx
        add     eax, 9
        cdqe
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-38H], rax
        mov     edx, dword [rbp-40H]
        mov     eax, dword [rbp-44H]
        add     eax, edx
        movsxd  rdx, eax
        mov     rax, qword [rbp-38H]
        mov     qword [rax], rdx
        add     qword [rbp-38H], 8
        mov     edx, dword [rbp-40H]
        mov     eax, dword [rbp-44H]
        add     eax, edx
        movsxd  rdx, eax
        mov     rax, qword [rbp-38H]
        add     rax, rdx
        mov     byte [rax], 0
        cmp     dword [rbp-44H], 0
        jz      L_030
        mov     rax, qword [rbp-38H]
        mov     byte [rax], 45
L_030:  mov     dword [rbp-3CH], 0
L_031:  mov     eax, dword [rbp-3CH]
        cmp     eax, dword [rbp-40H]
        jge     L_032
        mov     edx, dword [rbp-3CH]
        mov     eax, dword [rbp-44H]
        add     eax, edx
        movsxd  rdx, eax
        mov     rax, qword [rbp-38H]
        add     rdx, rax
        mov     eax, dword [rbp-40H]
        sub     eax, dword [rbp-3CH]
        cdqe
        mov     eax, dword [rbp+rax*4-30H]
        add     eax, 48
        mov     byte [rdx], al
        add     dword [rbp-3CH], 1
        jmp     L_031

L_032:  mov     rax, qword [rbp-38H]
        sub     rax, 8
        mov     rsi, qword [rbp-8H]


        xor     rsi, qword [fs:abs 28H]
        jz      L_033
        call    __stack_chk_fail
L_033:  leave
        ret


_member_string_substring:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 32
        mov     qword [rbp-18H], rdi
        mov     dword [rbp-1CH], esi
        mov     dword [rbp-20H], edx
        mov     eax, dword [rbp-20H]
        sub     eax, dword [rbp-1CH]
        add     eax, 1
        mov     dword [rbp-0CH], eax
        mov     eax, dword [rbp-0CH]
        add     eax, 9
        cdqe
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-8H], rax
        mov     eax, dword [rbp-0CH]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        mov     qword [rax], rdx
        mov     eax, dword [rbp-1CH]
        cdqe
        add     rax, 8
        add     qword [rbp-18H], rax
        add     qword [rbp-8H], 8
        mov     dword [rbp-10H], 0
L_034:  mov     eax, dword [rbp-10H]
        cmp     eax, dword [rbp-0CH]
        jge     L_035
        mov     eax, dword [rbp-10H]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rdx, rax
        mov     eax, dword [rbp-10H]
        movsxd  rcx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rcx
        movzx   eax, byte [rax]
        mov     byte [rdx], al
        add     dword [rbp-10H], 1
        jmp     L_034

L_035:  mov     eax, dword [rbp-0CH]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        mov     rax, qword [rbp-8H]
        sub     rax, 8
        leave
        ret


_member_string_parseInt:
        push    rbp
        mov     rbp, rsp
        mov     qword [rbp-18H], rdi
        add     qword [rbp-18H], 8
        mov     byte [rbp-9H], 0
        mov     dword [rbp-8H], 0
L_036:  mov     eax, dword [rbp-8H]
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        movzx   eax, byte [rax]
        cmp     al, 47
        jle     L_037
        mov     eax, dword [rbp-8H]
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        movzx   eax, byte [rax]
        cmp     al, 57
        jle     L_038
L_037:  mov     eax, dword [rbp-8H]
        lea     edx, [rax+1H]
        mov     dword [rbp-8H], edx
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        movzx   eax, byte [rax]
        cmp     al, 45
        sete    al
        test    al, al
        jz      L_036
        mov     byte [rbp-9H], 1
        jmp     L_036

L_038:  mov     eax, dword [rbp-8H]
        lea     edx, [rax+1H]
        mov     dword [rbp-8H], edx
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        movzx   eax, byte [rax]
        movsx   eax, al
        sub     eax, 48
        mov     dword [rbp-4H], eax
L_039:  mov     eax, dword [rbp-8H]
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        movzx   eax, byte [rax]
        cmp     al, 47
        jle     L_040
        mov     eax, dword [rbp-8H]
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        movzx   eax, byte [rax]
        cmp     al, 57
        jg      L_040
        mov     edx, dword [rbp-4H]
        mov     eax, edx
        shl     eax, 2
        add     eax, edx
        add     eax, eax
        mov     ecx, eax
        mov     eax, dword [rbp-8H]
        lea     edx, [rax+1H]
        mov     dword [rbp-8H], edx
        movsxd  rdx, eax
        mov     rax, qword [rbp-18H]
        add     rax, rdx
        movzx   eax, byte [rax]
        movsx   eax, al
        add     eax, ecx
        sub     eax, 48
        mov     dword [rbp-4H], eax
        jmp     L_039

L_040:  cmp     byte [rbp-9H], 0
        jz      L_041
        mov     eax, dword [rbp-4H]
        neg     eax
        jmp     L_042

L_041:  mov     eax, dword [rbp-4H]
L_042:  pop     rbp
        ret


_member_string_ord:
        push    rbp
        mov     rbp, rsp
        mov     qword [rbp-8H], rdi
        mov     dword [rbp-0CH], esi
        add     dword [rbp-0CH], 8
        mov     eax, dword [rbp-0CH]
        movsxd  rdx, eax
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        movzx   eax, byte [rax]
        movsx   eax, al
        pop     rbp
        ret



SECTION .data   


SECTION .bss    


SECTION .rodata 

L_043:
        db 25H, 73H, 00H


