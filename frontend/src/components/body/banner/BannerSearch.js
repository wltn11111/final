import style from './BannerSearch.module.css'
import 'bootstrap/dist/css/bootstrap.css';
import Aos from 'aos';
import { useEffect, useState} from 'react';



export default function ({search, setSearch}) {

  const [keyWord ,setKeyword ] = useState({word : '', category : 'ALL'});

  const handleSearch = () => {
    if (keyWord.word == '') {
      alert("검색어를 입력해주세요")
      return;
    }
    setSearch(keyWord)
    setKeyword(prev => ({...prev,word : ""}))
  }

  const keyUpHandle = (e) => {
    if (e.key === "Enter") {
      handleSearch();
    }
  }


  useEffect(() => {
    Aos.init();
  }, []);

  return (
    <>
      <div className={`${style.search_container} d-flex justify-content-center`}
        data-aos="zoom-out-up"
        data-aos-delay="500"
        data-aos-duration="900"
        data-aos-easing="ease-in-out" >
        <div className={`${style.search_box} d-flex justify-content-center`}>
        <div className={style.category_box}>
        <select className={`${style.category}`}
        onChange={(e)=>{
          setKeyword(prev => ({...prev, category : e.target.value}))
        }}>
        <option key={"전체"} value={"ALL"} selected>전체</option>
        <option key={"라이프"} value={"FREEDOM"}>자유</option>
        <option key={"스포츠"} value={"IT"}>IT</option>
        <option key={"연예"} value={"SPORTS"}>운동</option>
        <option key={"자유"} value={"FASHION"}>패션</option>
          </select>
          </div>
          <div className={style.input_box}>
            <input type='text' placeholder='검색'
              value={keyWord.word}
              onChange={(e)=>{
              setKeyword(prev => ({...prev, word : e.target.value}))
              }}
            onKeyUp={keyUpHandle}
              >
            </input>
          </div>
          <div className={style.icon_box}>
            <i className="ri-search-line"
            onClick={handleSearch}></i>
          </div>
        </div>
      </div>
    </>
  )
}