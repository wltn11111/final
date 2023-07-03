import Aos from 'aos';
import {useEffect} from 'react';
import style from './Banner.module.css';
import 'bootstrap/dist/css/bootstrap.css';
import banner_img1 from '../../../assets/./images/banner_img1.png'
import banner_img2 from '../../../assets/./images/banner_img2.png'
import banner_img3 from '../../../assets/images/banner_img3.png'
import banner_img4 from '../../../assets/images/banner_img4.png'
import banner_img5 from '../../../assets/images/banner_img5.png'
import plant from '../../../assets/images/plant.png'
import women from '../../../assets/images/women.png'
import men from '../../../assets/images/banner_center.png'


export default function () {
  useEffect(() => {
    Aos.init();
  }, []);
  return (
    <div className={`${style.banner_container} container-flud`}>
      <div className={style.banner_img1}
           data-aos="fade-left"
           data-aos-delay="100"
           data-aos-duration="1200">
        <img src={banner_img1}></img>
      </div>
      <div className={style.text}
           data-aos="fade-up"
           data-aos-delay="600"
           data-aos-duration="1000"
           data-aos-easing="ease-in-out">
        <span>온전히</span>
      </div>
      <div
        data-aos="fade-up"
        data-aos-delay="750"
        data-aos-duration="1200"
        data-aos-easing="ease-in-out"
        className={style.text1}>
        <span>나에게만 몰입할 수 있는 <strong>공간</strong></span>
      </div>
      <div className={style.banner_img3}
           data-aos="fade-right"
           data-aos-delay="100"
           data-aos-duration="1000"
           data-aos-easing="ease-in-out"
      >
        <img src={banner_img3}/>
      </div>
      <div className={style.banner_img2}
           data-aos="fade-up-left"
           data-aos-delay="100"
           data-aos-duration="1000"
           data-aos-easing="ease-in-out"
      >
        <img src={banner_img2}/>
      </div>
      <div className={style.banner_img4}
           data-aos="fade-up-right"
           data-aos-delay="100"
           data-aos-duration="1000"
           data-aos-easing="ease-in-out"
      >
        <img src={banner_img4}/>
      </div>
      <div className={style.banner_plant}
           data-aos="fade-up-right"
           data-aos-delay="200"
           data-aos-duration="1000"
           data-aos-easing="ease-in-out"
      >
        <img src={plant}/>
      </div>
      <div className={style.banner_img5}
           data-aos="fade-left"
           data-aos-delay="100"
           data-aos-duration="1200">
        <img src={banner_img5}></img>
      </div>
      <div className={style.women}
           data-aos="fade-out-in"
           data-aos-delay="1200"
           data-aos-duration="1200">
        <img src={women}></img>
      </div>
      <div className={style.men}
           data-aos="fade-out-in"
           data-aos-delay="1300"
           data-aos-duration="1200">
        <img src={men}></img>
      </div>
    </div>
  )
}