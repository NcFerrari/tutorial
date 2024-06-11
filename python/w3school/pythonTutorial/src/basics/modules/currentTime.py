import time


def currentTime():
    return time.strftime("%H:%M:%S", time.localtime())


def currentTimeInMillis():
    return round(time.time() * 1000)
