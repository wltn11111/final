import style from './BoardBanner.module.css'
import 'bootstrap/dist/css/bootstrap.css';
import banner from '../../../assets/images/boardbanner.gif';
import { useEffect } from 'react';
import Aos from 'aos';
import { useNavigate } from 'react-router-dom';


export default function () {
  useEffect(() => {
    Aos.init();
  }, []);

  const Navigate = useNavigate();
  return (
    <>
      <div className={`${style.banner_container} d-flex justify-content-center`}>
        <div className={style.board_img}
          data-aos="flip-up"
          data-aos-delay="600"
          data-aos-duration="3000">
          <img src={banner}></img>
        </div>
        <div className={`${style.text1} d-none d-md-block`}
          data-aos="fade-right"
          data-aos-delay="100"
          data-aos-duration="700">
          <span className={style.span}>현재 당신의 관심사를</span></div>
        <div className={`${style.text2} d-none d-md-block`}
          data-aos="fade-up-left"
          data-aos-delay="500"
          data-aos-duration="700"
        >자유롭게 공유해주세요</div>
        <div className={`${style.text3} d-none d-md-block`}
          data-aos="fade-up"
          data-aos-delay="1000"
          data-aos-duration="900"
        ><strong>방구석 매거진</strong>에서는 누구나 작가가 될 수 있고 <br />
          <span className={style.span}> 무엇이든 컨텐츠가 될 수 있습니다.</span></div>
        <div className={style.btn_box}
          data-aos="zoom-in"
          data-aos-delay="1600"
          data-aos-duration="900">
          <button className={`${style.btn} d-none d-md-block`}
            onClick={() => {
              Navigate("/newpost")
              }
            }>글쓰러 가기</button>
        </div>
      </div>
    </>
  )
}