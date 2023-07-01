import Header from "../components/header/Header";
import Footer from "../components/footer/Footer";
import Login from "../components/body/login/Login";

export default function () {

  return (
    <>
      <Login></Login>
      <div style={{marginTop : "100px"}}><Footer></Footer></div>
    </>
  )

}