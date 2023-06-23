import ViewForm from "../components/body/board/ViewForm";
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from "../components/header/Header";
import Footer from "../components/footer/Footer";
import Reply from "../components/body/board/Reply";

export default function ({ posts }) {

  return (
    <>
      <Header></Header>
      <ViewForm posts={posts}></ViewForm>
      <Reply></Reply>
      <Footer></Footer>
    </>
  )
}