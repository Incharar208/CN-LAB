# simulation initialization
set ns [new Simulator]

# color configuration
# assigning different colours to differentiate the traffic
$ns color 1 Blue
$ns color 1 Red

# trace and nam file initialization
set ntrace [open Program2.tr w]
$ns trace-all $ntrace
set namfile [open Program2.nam w]
$ns namtrace-all $namfile

# finish procedure
proc Finish {} {
global ns ntrace namfile

# dump all trace data and close the files
$ns flush-trace
close $ntrace
close $namfile

# eexcution of nam file
exec nam Program2.nam &

# find the number of dropped packets
# puts - outputs a message to the console
# grep "^d"- Filters lines in the trace file that begin with 'd' (indicating dropped packets)
# cut -d " " -f 5: Extracts the fifth field (column) using a space as the delimiter
# grep -c "ping": Counts the occurrences of lines containing "ping
puts "The number of ping packets dropped are "
exec grep "^d" Program2.tr | cut -d " " -f 5 | grep -c "ping" 
exit 0 
}

# node creation
for {set i 0} {$i < 6} {incr i} {
set n{$i} [$ns node]
}

# node connection 
for {set j 0} {$j < 5} {incr j} {
$ns duplex-link $n($j) $n([expr ($j+1)]) 0.1Mb 10ms DropTail
