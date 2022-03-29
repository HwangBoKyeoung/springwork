<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
        #moveNameList {
            background: rgb(214, 186, 181);
        }
        .movieCd{
            background: orchid;
        }

        #peopleNm {

            margin: 2px;
            background: violet;
        }

        #peopleNmEn {

            margin: 2px;
            background: yellowgreen;
        }
    </style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
 
<body>

    <h3>영화정보</h3>
    원하는 날짜영화:<input type="date" id="searchDt" required><button id="btnBoxOffice">박스오피스</button>
    <div id="result">

    </div>

    <div id="actors"> 
       
    </div>

</body>
    <script>
        btnBoxOffice.addEventListener('click', getBoxOffice);
        function getBoxOffice() {
            $('#result').empty();
            let year = (searchDt.value).substring(0, 4);
            let month = (searchDt.value).substring(5, 7);
            let day = (searchDt.value).substring(8, 10);
            let date = year + month + day;
            let url =
                "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=" +
                date;
            fetch(url)
                .then(response => response.json())
                .then(response => {
                    console.log(response);
                    let list = response.boxOfficeResult
                        .dailyBoxOfficeList;
                    for (i = 0; i < list.length; i++) {
                        //div태그생성
                        let newDiv = document.createElement('div');
                        newDiv.innerHTML =
                            `<div><span  id="moveNameList">${list[i].movieNm}</span><span class="movieCd">${list[i].movieCd}</span></div>`;
                        result.append(newDiv);
                    }
                });
        }
        result.addEventListener('click', function () {
          $('#actors').empty();
         actors.innerHTML='';
            if (event.target.classList == 'movieCd') {
                console.log(event.target);
                let movieCd = event.target.innerText;
                let url =
                    "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=" +
                    movieCd;
                fetch(url)
                    .then(response => response.json())
                    .then(response => {
                        console.log(response);
                        let list = response.movieInfoResult.movieInfo.actors;
                        let h2 = document.createElement('h2');
                        h2.innerText = response.movieInfoResult.movieInfo.movieNm + "  출연진";
                        actors.append(h2);
                        for (i = 0; i < list.length; i++) {
                            console.log(list[i].peopleNm);
                            let newDiv = document.createElement('div');
                            newDiv.innerHTML =
                                `<div><span  id="peopleNm">${list[i].peopleNm}</span><span id="peopleNmEn">${list[i].peopleNmEn}</span></div>`;
                            actors.append(newDiv);
                        }
                    })
            }
        });
    </script>
</html>