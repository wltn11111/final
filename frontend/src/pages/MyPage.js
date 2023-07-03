import Sidebar from '../components/body/mypage/Sidebar'
import 'bootstrap/dist/css/bootstrap.css';
import {Outlet} from 'react-router-dom';

export default function () {

  return (
    <>
      <div className="container-flud">
        <div className="row">
          <div className="d-none d-md-block col-2">
            <Sidebar></Sidebar>
          </div>
          <div className="co1-12 col-md-10 start">
            <Outlet></Outlet>
          </div>
        </div>
        <div style={{marginTop: "80px"}}></div>
      </div>
    </>
  )
}
