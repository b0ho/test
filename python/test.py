from pytube import YouTube
from pytube import Playlist
import pytube

pl = Playlist(
    'https://www.youtube.com/playlist?list=PLokjDpRxx3_qLa-V8m19Vh3J4OVWWfNsl')
pl.download_all('C:\\Users\\ybg48\\Downloads')

yt = YouTube(
    'https://www.youtube.com/watch?v=7k4WRNbzGSM&index=30&list=PLO6aYJJHi7hBHtB6uqWPm22Oow8EhYIEC&t=0s')

dir = 'C:\\Users\\ybg48\\Downloads'

#video = yt.get('mp4', 480)

# video.download(dir)
# YouTube('https://www.youtube.com/watch?v=j7ymH0v1bfI&index=78&list=PLldmudk5IZFWmXOxgukwwiSgb_TyB3rBY&t=0s').streams.first().download(dir)
# YouTube('https://www.youtube.com/watch?v=Fbw3alUxhvk&index=31&list=PLO6aYJJHi7hBHtB6uqWPm22Oow8EhYIEC&t=0s').streams.first().download('./download')
# YouTube('https://www.youtube.com/watch?v=XgjQjNKqY-w&index=32&list=PLO6aYJJHi7hBHtB6uqWPm22Oow8EhYIEC&t=0s').streams.first().download('./download')
# YouTube('https://www.youtube.com/watch?v=xpDZXOCNKww&index=33&list=PLO6aYJJHi7hBHtB6uqWPm22Oow8EhYIEC&t=0s').streams.first().download('./download')
# YouTube('https://www.youtube.com/watch?v=RJ0mXmFA820&index=34&list=PLO6aYJJHi7hBHtB6uqWPm22Oow8EhYIEC&t=0s').streams.first().download('./download')

print("완료")
