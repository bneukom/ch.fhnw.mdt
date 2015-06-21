\
\ Last_change: KS 19.03.2013 09:21:22
\
\ MicroCore load screen for the core test program that is transferred
\ into the program memory via the debug umbilical
\
Only Forth also definitions hex

[IFDEF] empty unpatch close-port empty [ENDIF] Marker empty

include gforth-config.fs        \ Some System word (re)definitions for a more sympathetic environment
include vhdl.fs                 \ simple VHDL interpreter for constants
include ../uCore/constants.vhd
include microcore.fs            \ the cross-compiler
include images.fs               \ object code output files
include disasm.fs               \ the disassembler
include umbilical.fs            \ defines the actual serial port used on this computer
include constants.fs            \ MicroCore Register addresses and bits

$DEBUG_INCLUDE

new Target                      \ reset target compiler and go into target compilation mode

8 trap-addr code-origin
          0 data-origin  Initialised

include forth.fs
include debugger.fs
Uninitialised
include multitask.fs

include $INPUT_FILE

: boot  ( -- )
   0 #top erase  CALL Initialisation
   init   debugService
;

#reset USR: rst    ( -- ) ['] boot             nop BRANCH ;USR  \ compile branch to TEST at reset vector location
#isr   USR: isr    ( -- ) ints@ drop                 IRET ;USR
#esr   USR: esr    ( -- ) ['] exceptionService nop BRANCH ;USR  \ retry instruction
#osr   USR: osr    ( -- )                            EXIT ;USR  \ ?OVFL Vektor
#break USR: break  ( -- ) ['] debugger         nop BRANCH ;USR  \ Debugger
#data! USR: data!  ( dp-1 n -- dp )  swap 1+ st      EXIT ;USR  \ Data memory initialisation

end

\ CRC-file load.crc  cr .( load.fs written to load.crc )