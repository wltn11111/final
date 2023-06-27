import ViewForm from "../components/body/board/ViewForm";
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from "../components/header/Header";
import Footer from "../components/footer/Footer";
import Reply from "../components/body/board/Reply";
import { useLocation } from "react-router-dom";


export default function ({ replys, setReplys  }) {
  const location = useLocation();
  const { from } = location.state;

  return (
    <>
      <Header></Header>
      <ViewForm post={from}></ViewForm>
      <Reply replys={replys} setReplys={setReplys}></Reply>
      <div style={{marginTop : "80px"}}>
      <Footer></Footer> </div>
    </>
  )
}