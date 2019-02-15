num_stamp = 0  # 쿠폰 스탬프가 찍힌 횟수 (전역변수)


def stamp():
    """쿠폰 스탬프가 찍힌 횟수를 증가시키고, 화면에 출력한다."""
    global num_stamp           # ❶ num_stamp는 전역변수다
    num_stamp = num_stamp + 1  # 이제 오류가 발생하지 않는다
    print(num_stamp)


stamp()  # 화면에 1이 출력된다
stamp()  # 화면에 2가 출력된다
