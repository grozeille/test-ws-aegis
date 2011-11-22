using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using TestWebService.localhost;

namespace TestWebService
{
    public class MyDtoEventArgs : EventArgs
    {
        public MyDto MyDto { get; private set; }

        public MyDtoEventArgs(MyDto myDto)
        {
            this.MyDto = myDto;
        }
    }
}
