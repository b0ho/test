import requests
from bs4 import BeautifulSoup
from collections import OrderedDict
from itertools import count #count 불러오기
 
 
def rednooby_cralwler(input_search):
    url = 'https://search.naver.com/search.naver'
    post_dict = OrderedDict()
    
    for page in count(1):#1부터 무한대로 시작(break or return이 나올때까지)
        params = {
            'query': input_search,
            'where': 'post',
            'start': (page-1)*10+1,
        }
        print(params)
        response = requests.get(url, params=params)
        html = response.text
 
        #뷰티풀소프의 인자값 지정
        soup = BeautifulSoup(html, 'html.parser')
 
        #쪼개기
        title_list = soup.select('.sh_blog_title')
 
        for tag in title_list:
            if tag['href'] in post_dict:
                return post_dict#여기 오게되면 count는 종료됩니다.
            
            print(tag.text, tag['href'])
            post_dict[tag['href']] = tag.text
    return post_dict




