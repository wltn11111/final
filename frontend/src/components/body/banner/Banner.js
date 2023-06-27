import Aos from 'aos';
import { useEffect } from 'react';
import style from './Banner.module.css';
import 'bootstrap/dist/css/bootstrap.css';
import banner_img1 from '../../../assets/./images/banner_img1.png'
import banner_img2 from '../../../assets/./images/banner_img2.png'


export default function () {
  useEffect(() => {
    Aos.init();
  }, []);
  return (
    <div className={`${style.banner_container} container-flud`}>
      <div className={style.banner_img1}
        data-aos="fade-left"
        data-aos-delay="100"
        data-aos-duration="1000">
        <img src={banner_img1} style={{ width: "100%", height: "100%" }}></img>
      </div>
      <div
        data-aos="fade-up"
        data-aos-delay="100"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        style={{ margin: "auto", fontSize: "48px", textAlign: "center" }}>
        나의 성장과 행복을 위한 공간
      </div>

      {/* <div className={style.banner_img2}
        data-aos="fade-right"
        data-aos-delay="100"
        data-aos-duration="1000">
        <img src={banner_img2} style={{ width: "100%", height: "100%" }}></img>
      </div> */}
    </div>
  )
}