import requests
from bs4 import BeautifulSoup
from collections import OrderedDict
from itertools import count
import json
import os
import urllib.request


def crawl(url_start, num, url_end, base_dir):
    BASE_DIR = os.path.dirname(os.path.abspath(base_dir))

    print("start")
    data = {}
    for page in range(1, num):
        page_num = str(page)
        req = requests.get(url_start+page_num+url_end)
        html = req.text

        #url2 = 'https://www.instiz.net/pt?no=5983103&page=1&srt=3&k=&srd=1'
        #html2 = urllib.request.urlopen(url2)
        #source2 = html2.read()
        #soup2 = BeautifulSoup(html2, 'html.parser')

        #base_url = 'http://file3.instiz.net/'
        #img = soup2.find('img')
        # print()
        #img_src = img.get('src')
        #img_url = base_url+img_src
        #img_name = img_src.replace('/',"")
        #urllib.request.urlretrieve(img_url, './img/'+img_name)

        # print(img_src)

        soup = BeautifulSoup(html, 'html.parser')

        my_titles = soup.select(
            #'td.tit > a'
            'td.listsubject>a'
        )

        my_images = soup.select(
            'memo_content '
        )

        for image in my_images:
            print(image['src'])

        for title in my_titles:
            print(title.text, title['href'])
            data[title.text] = 'https://www.instiz.net'+title.get('href')

    print("end")

    sorted(data.items())

    with open(os.path.join(BASE_DIR, 'result.json'), 'w+') as json_file:
        json.dump(data, json_file)


crawl('https://www.instiz.net/pt?&page=', 5, '&srt=3&k=&srd=1', 'D:/')
