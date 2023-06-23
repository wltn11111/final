import 'bootstrap/dist/css/bootstrap.min.css';
import Navi from './navi/Navi';
import { LogOutIcon, LoginIcon } from './icon/Icon';

export default function ({ setHeaderView, setSearchView }) {

  return (

    <div className="row sticky-top header" style={{ margin: "0px", backgroundColor: "white" }}>
      <div className="col-6 col-md-2"></div>
      <div className="d-none d-md-block col-md-8">
        <Navi> </Navi>
      </div>
      <div className="col-6 col-sm-none col-md-2" id="icon_area">
        {/* <LogOutIcon setHeaderView ={setHeaderView} setSearchView = {setSearchView}></LogOutIcon> */}

         <LoginIcon setHeaderView={setHeaderView} setSearchView={setSearchView}></LoginIcon>
      </div>

    </div>

  )
}