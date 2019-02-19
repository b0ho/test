from pytube import YouTube
from pytube import Playlist
import subprocess

# 저장 경로
dir = 'C:\\Users\\ybg48\\Downloads'


# 개별 다운
# YouTube('https://www.youtube.com/watch?v=84ATav-CqP4').streams.first().download(dir)


# 플레이리스트 다운
pl = Playlist('https://www.youtube.com/watch?v=84ATav-CqP4')
pl.download_all(dir)

print("완료")
