<!DOCTYPE html>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>404 Page not found</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="/static/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="/static/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="/static/plugins/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="./static/js/html5shiv.min.js"></script>
  <script src="./static/js/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">

  <!-- Content Wrapper. Contains page content -->
  <div >
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        <span style="color: #c0a16b">Where is it possible to make an error !</span>
      </h1>

    </section>

    <!-- Main content -->
    <section class="content">
      <div class="error-page">
        <h2 class="headline text-yellow"> 404</h2>

        <div class="error-content">
          <h3><i class="fa fa-warning text-yellow"></i> Oops! Page not found.</h3>

          <p>
            We could not find the page you were looking for.
            Meanwhile, you may <a href="../../index.html">return to dashboard</a> or try using the search form.
          </p>

          <form class="search-form">
            <div class="input-group">
              <input type="text" name="search" class="form-control" placeholder="Search">

              <div class="input-group-btn">
                <button type="submit" name="submit" class="btn btn-warning btn-flat"><i class="fa fa-search"></i>
                </button>
              </div>
            </div>
            <!-- /.input-group -->
          </form>
        </div>
        <!-- /.error-content -->
      </div>
      <!-- /.error-page -->
    </section>
    <!-- /.content -->
  </div>

  <!-- jQuery 2.2.3 -->
  <script src="/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
  <!-- Bootstrap 3.3.6 -->
  <script src="/static/bootstrap/js/bootstrap.min.js"></script>
  <!-- iCheck -->
  <script src="/static/plugins/iCheck/icheck.min.js"></script>

</body>
</html>
