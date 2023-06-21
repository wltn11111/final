import Header from '../Components/Header/Header';
import Footer from '../Components/Footer/Footer';
import Sidebar from '../Components/Body/MyPage/Sidebar';
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
