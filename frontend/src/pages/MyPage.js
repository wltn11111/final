import Header from '../components/header/Header';
import Footer from '../components/footer/Footer';
import Sidebar from '../components/body/mypage/Sidebar'
import 'bootstrap/dist/css/bootstrap.css';
import { Outlet } from 'react-router-dom';

export default function () {
  return (
    <>
  <Header></Header>
    <div className="container-flud">
      <div className="row">
        <div className="col-2">
          <Sidebar></Sidebar>
        </div>
        <div className="col-10">
            <Outlet></Outlet>
        </div>
      </div>
    </div>
      <Footer></Footer>
    </>


  )
}
