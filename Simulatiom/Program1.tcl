# simulator initialization
set ns [new Simulator]

# Trace file and NAM file initialization
set ntrace [open Program1.tr w]
$ns trace-all $ntrace
set namfile [open Program1.nam w]
$ns namtrace-all $namfile

# Finish procedure
proc Finish {} {
global ns ntrace namfile

# flushes trace data 
# closes files
$ns flush-trace
close $ntrace
close $namfile

# executes NAM animation
exec nam Program1.nam &

# displays the number of packets
exec echo "The number of packets drop is " &
exec grep -c "^d" Program1.tr &
exit 0
}

# Node creation
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]

# Node labelling
$n0 label "TCP Source"
$n2 label "Sink"

# setting the color
$ns color 1 blue

# Establishing links between the nodes
# Delay - 10ms
# Bandwidth - 1Mb
# Queue management - DropTail
$ns duplex-link $n0 $n1 1Mb 10ms DropTail
$ns duplex-link $n1 $n2 1Mb 10ms DropTail

# Link orientation
$ns duplex-link-op $n0 $n1 orient right
$ns duplex-link-op $n1 $n2 orient right

# setting the queue size
$ns queue-limit $n0 $n1 10
$ns queue-limit $n1 $n2 10

# Transport layer setup
set tcp0 [new Agent/TCP]
$ns attach-agent $n0 $tcp0
set sink0 [new Agent/TCPSink]
$ns attach-agent $n2 $sink0
$ns connect $tcp0 $sink0

# Application layer setup
# cbr - current bit rate
set cbr0 [new Application/Traffic/CBR]
$cbr0 set type_ CBR
$cbr0 set packetSize_ 100
$cbr0 set rate_ 1Mb
$cbr0 set random_ false
$cbr0 attach-agent $tcp0
$tcp0 set class_ 1

# Event scheduling
$ns at 0.0 "$cbr0 start"
$ns at 5.0 "Finish"

# Simulation Execution
$ns run
