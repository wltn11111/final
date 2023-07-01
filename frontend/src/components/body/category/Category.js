import 'bootstrap/dist/css/bootstrap.css';
import style from './Category.module.css'
import { useEffect } from 'react';
import Aos from 'aos';
import free from '../../../assets/images/free.png'
import sports from '../../../assets/images/sports.png'
import it from '../../../assets/images/it.png';
import fashoin from '../../../assets/images/fashoin.png'
import "aos/dist/aos.css";

export default function () {
  useEffect(() => {
    Aos.init();
  }, []);

  return (

    <div className={`${style.container} container d-flex justify-content-center`}>
      <div data-aos="fade-up"
        data-aos-delay="100"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        className={style.category}>
        <img src={free} style={{ width: "100%", height: "100%" }}></img> </div>
      <div data-aos="fade-up"
        data-aos-delay="200"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        className={style.category}>
        <img src={sports} style={{ width: "100%", height: "100%" }}></img> </div>
      <div data-aos="fade-up"
        data-aos-delay="400"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        className={style.category}>
        <img src={it} style={{ width: "100%", height: "100%" }}></img>  </div>
      <div data-aos="fade-up"
        data-aos-delay="600"
        data-aos-duration="1000"
        data-aos-easing="ease-in-out"
        className={style.category}>
        <img src={fashoin} style={{ width: "100%", height: "100%" }}></img>  </div>
    </div>
  )
}