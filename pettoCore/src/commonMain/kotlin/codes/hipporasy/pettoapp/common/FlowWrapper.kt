package codes.hipporasy.pettoapp.common

expect class FlowWrapper<T>(suspender: suspend () -> T)
