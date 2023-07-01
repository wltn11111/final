import style from './BannerSearch.module.css'
import 'bootstrap/dist/css/bootstrap.css';
import Aos from 'aos';
import { useEffect } from 'react';



export default function () {

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
            <select className={`${style.category}`}>
              <option>자유</option>
              <option>운동</option>
              <option>IT</option>
              <option>패션</option>
            </select>
          </div>
          <div className={style.input_box}>
            <input type='text' placeholder='검색'>
            </input>
          </div>
          <div className={style.icon_box}>
            <i className="ri-search-line"></i>
          </div>
        </div>
      </div>
    </>
  )
}